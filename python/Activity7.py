numbers = list(input("Enter a sequence of comma separated values: ").split(", "))
sum = 1
for number in numbers:
  sum += int(number)

print(sum)