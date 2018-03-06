#a generator is a lazy, incrementally-pending list, and yield statements allow you to use function notation to program the list values
print("Generators")
def create_generator(count):
    mylist = range(count)
    for i in mylist:
        yield i*i


def main():
    print('Hello')
    my_generator = (x*x for x in range(1,5))
    for i in my_generator:
        print(i)
    print("generator with yield")
    yield_generator = create_generator(5)
    for i in yield_generator:
        print(i)

if __name__ == '__main__':
    main()