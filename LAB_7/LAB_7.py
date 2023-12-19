import sys

# Get the size of the square matrix from the user
nRows = int(input("Enter the size of the square matrix: "))

# Check if the entered size is correct
if nRows <= 0:
    print("Invalid matrix size")
    sys.exit(1)

# Get the filler character from the user
filler = input("Enter the filler character: ")
if len(filler) == 0:
    print("No filler character entered")
    sys.exit(1)
elif len(filler) != 1:
    print("Too many filler characters")
    sys.exit(1)

# Initialize the matrix
arr = []
pos = 0
for i in range(nRows):
    row = []
    if i >= nRows / 2:
        if i != nRows / 2:
            pos = pos - 1
    else:
        pos = pos + 1
    for j in range(nRows):
        if j < pos or j > nRows - pos - 1:
            row.append(filler)
    arr.append(row)

# Print the matrix and save it to a file
pos = 0
res = ""
for i in range(nRows):
    if i >= nRows / 2:
        if i != nRows / 2:
            pos = pos - 1
    else:
        pos = pos + 1
    k = 0
    for j in range(nRows):
        if j < pos or j > nRows - pos - 1:
            print(f"{arr[i][k]} ", end="")
            res += arr[i][k] + " "
            k += 1
        else:
            print("  ", end="")
            res += "  "
    print("")
    res += "\n"

# Write the matrix to a file
with open("results.txt", 'w') as file:
    file.write(str(res) + '\n')