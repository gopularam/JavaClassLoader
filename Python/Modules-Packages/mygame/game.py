import draw

def play_game():
    print("inside play game.")
    return "play_game"

def main():
    result = play_game()
    draw.draw_game(result)
#Modules are imported as singletons
if __name__ == '__main__':
    main()