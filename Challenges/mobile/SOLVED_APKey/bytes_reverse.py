byte_str = 'a2a3d412e92d896134d9c9126d756f'

possible_hashes = []
for i in range(len(byte_str)+2):
    x = byte_str[:i] + '0' + byte_str[i:]
    for j in range(len(byte_str)+2):
        y = x[:j] + '0' + x[j:]
        possible_hashes.append(y)

possible_hashes = set(possible_hashes)
with open('hashes.txt', 'w') as f:
    for h in possible_hashes:
        f.write(f'{h}\n')
