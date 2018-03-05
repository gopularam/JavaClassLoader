class Address:
    Street = "VTV"
    def function(self): 
        print("function called")
objx = Address()
objy = Address()
objx.Street = "PTP"
print(objx.Street)
print(objy.Street)
