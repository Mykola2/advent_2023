import file_fetcher

words = [
    "zero", "one", "two", "three", "four",
    "five", "six", "seven", "eight", "nine"
]


def main():
    result = []
    lines = file_fetcher.fetch_all_lines()
    for line in lines:
        word_digit_indexes = sum([word_digits_indexes(line, word) for word in words], [])
        digit_indexes = digit_indexes_in_string(line)
        all_indexes = sorted(word_digit_indexes + digit_indexes, key=lambda x: x[0])
        result.append(int(all_indexes[0][1] + all_indexes[-1][1]))
    print(sum(result))


def word_digits_indexes(string, word):
    start_index = 0
    result = []
    while start_index < len(string):
        index_of = string.find(word, start_index)
        if index_of == -1:
            break
        result.append((index_of, str(words.index(word))))
        start_index = index_of + 1
    return result


def digit_indexes_in_string(string):
    return [(index, char) for index, char in enumerate(string) if char.isdigit()]


if __name__ == "__main__":
    main()