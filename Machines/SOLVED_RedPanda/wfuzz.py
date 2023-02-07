#!/usr/bin/python
import os
import sys
import argparse
import multiprocessing as mp
from slugify import slugify

WORDLISTS = {
    'Generic':              ['/usr/share/wfuzz/wordlist/Injections/All_attack.txt'],
    'SQLi':                 ['/usr/share/seclists/Fuzzing/SQLi/Generic-SQLi.txt'],
    'Command inction':      ['/usr/share/seclists/Fuzzing/command-injection-commix.txt'],
    'SSTI':                 ['/usr/share/seclists/Fuzzing/template-engines-expression.txt',
                             '/usr/share/seclists/Fuzzing/template-engines-special-vars.txt'],
    'XXE':                  [],
    'XSS':                  []
}

def proc(wordlist, args, url, outfile):
    os.system('wfuzz -c -w {} {} -f {},raw {} > /dev/null'.format(wordlist, args, outfile, url))

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('-u', '--url', action='append', required=True)
    parser.add_argument('-s', '--set', choices=WORDLISTS.keys(), action='append')
    parser.add_argument('-a', '--wfuzz_args', default='')
    parser.add_argument('-o', '--out', required=True)
    parser.add_argument('-w', '--workers', type=int, default=10)
    args = parser.parse_args()

    assert os.path.exists(args.out)
    if args.set == None:
        args.set = WORDLISTS.keys()

    proc_args = []
    for url in args.url:
        for s in args.set:
            for i, wordlist in enumerate(WORDLISTS[s]):
                outfile = args.out + '/' + slugify(url) + '_' + s + '_' + str(i)
                proc_args.append((wordlist, args.wfuzz_args, url, outfile))

    with mp.Pool(args.workers) as pool:
        pool.starmap(proc, proc_args)
