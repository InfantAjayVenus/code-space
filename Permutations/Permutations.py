def get_permutations(input_list):
    if len(input_list) == 0:
        return []

    first_element = input_list.pop(0)
    print(first_element, input_list)
    permutation_without_first = get_permutations(input_list)
    permutations = []

    for element in permutation_without_first:
        for i in range(len(element)):
            merged_element_list = list(element)
            merged_element_list.insert(i, first_element)
            permutations.append(''.join(merged_element_list))

    if len(permutations) == 0:
        return [first_element]

    return permutations


def test_permutation(input_string):
    print("Permutation({}) => {}".format(input_string, get_permutations(list(input_string))))

test_permutation('abc')
