# Combinations

Given a list of items, generate all possible combinations of given length.
If no length is given, generate all possible combinations of all lengths.

## Algorithm

The Recursive algorithm used for generating all combinations is as follows,

COMBINATIONS(LIST):

1. If LIST is empty return EMPTY_SET
2. set COMB_WITHOUT_LIST[0] = COMBINATIONS(LIST - LIST[0])
3. set COMB_WITH_LIST[0] = MERGE(LIST[0], COMB_WITHOUT_LIST[0])
4. return CONCAT(COMB_WITHOUT_LIST[0], COMB_WITH_LIST[0])
