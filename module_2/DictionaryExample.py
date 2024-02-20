# Creating a dictionary where the keys are fruit names and the values are their prices
fruit_prices = {
    'apple': 0.65,
    'banana': 0.35,
    'cherry': 0.20,
    'date': 1.50
}

# Accessing the price of an apple
apple_price = fruit_prices['apple']
print(f"The price of an apple is ${apple_price} per unit.")

# Adding a new fruit to the dictionary
fruit_prices['elderberry'] = 3.45

# Updating the price of cherries
fruit_prices['cherry'] = 0.25

# Removing the banana entry using del
del fruit_prices['banana']

# Checking if a fruit is in the dictionary
if 'banana' in fruit_prices:
    print("Banana is in the fruit list.")
else:
    print("Banana is not in the fruit list.")

# Iterating over the dictionary to print out all fruits and their prices
for fruit, price in fruit_prices.items():
    print(f"{fruit.capitalize()} costs ${price} per unit.")
