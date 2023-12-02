import math

import file_fetcher


def main():
    result = []
    game_lines = file_fetcher.fetch_all_lines()
    for game_line in game_lines:
        data = [sets.strip().split(", ") for sets in game_line.split(":")[1].split(";")]
        max_cubes = max_cubes_by_color(data)
        result.append(math.prod(max_cubes.values()))

    print(sum(result))


def max_cubes_by_color(sets):
    max_cubes_per_color = {"red": 0, "blue": 0, "green": 0}
    for set in sets:
        for item in set:
            split = item.split(" ")
            color = split[1]
            count = int(split[0])
            max_cubes_per_color[color] = max(max_cubes_per_color[color], count)

    return max_cubes_per_color


if __name__ == "__main__":
    main()