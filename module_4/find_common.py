def find_common_naive(set1, set2):
    """Find common elements between two sets (naive approach)."""
    """Complexity: O(n^2)"""
    common = []
    for elem in set1:  # O(n)
        if elem in set2:  # O(n^2)
            common.append(elem)
    return common


def find_common_sorted(set1, set2):
    """Find common elements between two sets (efficient approach using sorting)."""
    """Complexity: O(n log n)"""
    common = []
    sorted_set1 = sorted(set1)  # O(n log n)
    sorted_set2 = sorted(set2)  # O(m log m)
    i, j = 0, 0
    while i < len(sorted_set1) and j < len(sorted_set2):  # O(n)
        # Use a seperate index for each set to compare elements, because they may have different lengths
        if sorted_set1[i] == sorted_set2[j]:
            common.append(sorted_set1[i])
            i += 1
            j += 1
        elif sorted_set1[i] < sorted_set2[j]:
            i += 1
        else:
            j += 1
    return common


def find_common_sorted_python(set1, set2):
    """Find common elements between two sets efficiently with sorting."""

    # Convert sets to Python set data structure (if not already) and find intersection
    common_set = set(set1).intersection(set2)

    # Sort the result of the intersection
    common_sorted = sorted(common_set)

    return common_sorted


# Example usage
set1 = {1, 3, 5, 7, 9}
set2 = {1, 2, 3, 4, 5}

# Naive approach
print("Common elements (naive):", find_common_naive(set1, set2))

# Efficient approach
print("Common elements (sorted):", find_common_sorted(set1, set2))
