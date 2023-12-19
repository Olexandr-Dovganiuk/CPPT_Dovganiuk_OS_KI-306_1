import math
import pickle

# Function to calculate the expression y = tg(x)/sin(2x)
def calculate_expression(x):
    try:
        result = math.tan(x) / math.sin(2 * x)
        return result
    except ZeroDivisionError:
        print("Error: sin(2x) is undefined when tan(x) = 0.")
        return None

# Function to save data to a text file
def save_to_text_file(filename, data):
    with open(filename, 'w') as file:
        file.write(str(data) + '\n')

# Function to save data to a binary file
def save_to_binary_file(filename, data):
    with open(filename, 'wb') as file:
        pickle.dump(data, file)

# Function to read data from a text file
def read_from_text_file(filename):
    data = []
    try:
        with open(filename, 'r') as file:
            data = (float(file.read()))
    except FileNotFoundError:
        print(f"Error: File '{filename}' not found.")
    return data

# Function to read data from a binary file
def read_from_binary_file(filename):
    data = []
    try:
        with open(filename, 'rb') as file:
            data = pickle.load(file)
    except FileNotFoundError:
        print(f"Error: File '{filename}' not found.")
    return data

# Get the value of x from the user
x = float(input("y = tg(x)/sin(2x)\nEnter x:"))
res = calculate_expression(x)
print(f"result: {res}")

# Save the result to a text file
save_to_text_file("results.txt", res)
# Save the result to a binary file
save_to_binary_file("results.dat", res)

# Read the result from the text file
text_data = read_from_text_file("results.txt")
# Read the result from the binary file
binary_data = read_from_binary_file("results.dat")

print("Results from text file:", text_data)
print("Results from binary file:", binary_data)