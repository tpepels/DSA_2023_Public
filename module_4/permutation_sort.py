def is_sorted(lst):
    """Check if the list is sorted in ascending order."""
    return all(lst[i] <= lst[i + 1] for i in range(len(lst) - 1))


def generate_permutations(lst, start=0, result=[]):

    if start == len(lst) - 1:
        if is_sorted(lst):
            print("Sorted permutation found:", lst)
            result.append(lst.copy())  # Copy the sorted permutation to result
            return True

    for i in range(start, len(lst)):
        # Swap the current index with the start
        lst[start], lst[i] = lst[i], lst[start]
        # Recursively call the function with the next start index
        if generate_permutations(lst, start + 1, result):
            return result[0]  # Return immediately upon finding the first sorted permutation
        # Backtrack and swap the elements back
        lst[start], lst[i] = lst[i], lst[start]
    return False


# Example usage
lst = [3, 1, 2]
sorted_permutation = generate_permutations(lst)

if sorted_permutation:
    print("First sorted permutation:", sorted_permutation)
else:
    print("No sorted permutation found.")
