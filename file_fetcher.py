def fetch_all_lines():
    with open("input.txt", 'r') as file:
        lines = file.readlines()
    return lines
