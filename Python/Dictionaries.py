phonebook = {}
phonebook["Bhanu"] = 1234
phonebook["Sai"] = 3456
phonebook["ashrith"] = 7890
phonebook["ddd"] = 7777
phonebook["eee"] = 7777

print(phonebook)

for name , number in phonebook.items():
    print("Phone number of %s is %d" % (name, number))
del phonebook['ddd']
phonebook.pop('eee')
print(phonebook)
