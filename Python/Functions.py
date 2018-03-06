from functools import partial

def sum_numbers(a,b,c):
    return a+b+c

def var_args(a, *b):
    try:
        print(a)
        print(b)
        if a == 10:
            raise("Invalid data")
    except: 
        print("Exception caught: Invalid data in a:%d" % a)

x = sum_numbers(5,6,7)
print("sum %d" % x)
var_args(1,2,3,4,5)

#partial functions:
def multiply(x,y):
    return x*y

dbl = partial(multiply, 3)
print(dbl(6))

#Nested functions
def transmit_to_space(message):
  def data_transmitter():
      nonlocal message 
      print("Inside:"+message)
      message = "Modified"
      print("Inside:"+message)
  return data_transmitter
  #print("outer:"+message)

fun2 = transmit_to_space("Hello Nested function!")
fun2()