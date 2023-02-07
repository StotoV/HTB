import re

with open('./b64_strings', 'r') as file:
    with open('./b64_strings_filtered', 'w') as outfile:
        for line in file:
            if re.match('var\/www.*', line):
                outfile.write(line)
