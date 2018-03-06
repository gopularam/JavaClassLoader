mylist = []
mylist.append(1)
mylist.append(2)
mylist.append(5)
for x in mylist:
    print(x)
names = ["Bhanu", "Sai", "Ashrith"]
for y in names:
    print("Name:"+y)
names2 = ["astronaut"]
total = names+names2
for y in total:
    print("full:"+y)
print("List: %s" % names)

# Print Positive numbers
numbers = [34.6, -203.4, 44.9, 68.3, -12.2, 44.6, 12.7]
newlist = [float(x) for x in numbers if x>0]
print(newlist)


