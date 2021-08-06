def get_combinations(input_list):
    if len(input_list) == 0:
        return []
    
    first_element = input_list.pop(0)
    combinations = get_combinations(input_list)
    combinations = combinations + ["{}{}".format(first_element, item) for item in combinations]
    combinations.insert(0, first_element)

    return combinations


def test_combinations(input_string):
    print("combination({}) => {}".format(input_string, get_combinations(list(input_string))))


test_combinations('')
test_combinations('a')
test_combinations('ab')
test_combinations('abc')
test_combinations('test')
