
def fibinocci():
    a,b = 1,1
    while 1:
        yield a
        a,b = b, a+b

def main():
    counter =0
    for i in fibinocci():
        print(i)
        counter+=1
        if counter == 5:
            break
    print('Done')

if __name__ == '__main__':
    main()