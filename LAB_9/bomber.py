from airplane import Airplane
from datetime import datetime

# Class representing a bomber, which is a type of airplane
class Bomber(Airplane):
    def __init__(self, make, model, weapon):
        # Inherits from the Airplane class
        super().__init__(make, model)
        # The weapon used by the bomber
        self.weapon = weapon
        # The number of bombs the bomber has, initially set to 10
        self.bombs = 10 

    # Method to make the bomber drop bombs
    def drop_bombs(self):
        # If there are bombs available, the bomber drops a bomb and the count decreases by 1
        if self.bombs > 0:
            print(f"[{datetime.now()}][{self.make}][{self.model}] is drop bombs")
            self.bombs -= 1
        # If there are no bombs available, the bomber cannot drop bombs and a message is printed
        else:
            print("Out of bombs. Please reload.")

    # Method to make the bomber defend
    def defend(self):
        print(f"[{datetime.now()}][{self.make}][{self.model}] is defending")

    # Method to reload the bomber's weapon
    def reload_weapon(self):
        print(f"[{datetime.now()}][{self.make}][{self.model}] weapon is being reloaded")
        # The number of bombs is set to 10
        self.bombs = 10 

    # Method to check the number of bombs the bomber has
    def check_ammo_count(self):
        print(f"[{datetime.now()}][{self.make}][{self.model}] bombs count: {self.bombs}")