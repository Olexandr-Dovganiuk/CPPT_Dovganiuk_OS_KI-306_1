from datetime import datetime

# Class representing an airplane
class Airplane:
    def __init__(self, make, model):
        # The make of the airplane
        self.make = make
        # The model of the airplane
        self.model = model
        # The fuel level of the airplane, initially set to 100
        self.fuel_level = 100

    # Method to make the airplane fly
    def fly(self):
        # If the fuel level is greater than 0, the airplane flies and fuel level decreases by 10
        if self.fuel_level > 0:
            print(f"[{datetime.now()}][{self.make}][{self.model}] is flying")
            self.fuel_level -= 10
        # If the fuel level is 0 or less, the airplane cannot fly and a message is printed
        else:
            print("Not enough fuel. Please refuel.")

    # Method to make the airplane land
    def land(self):
        print(f"[{datetime.now()}][{self.make}][{self.model}] is landing")

    # Method to refuel the airplane
    def refuel(self):
        print(f"[{datetime.now()}][{self.make}][{self.model}] is being refueled")
        # The fuel level is set to 100
        self.fuel_level = 100

    # Method to check the fuel level of the airplane
    def check_fuel_level(self):
        print(f"[{datetime.now()}][{self.make}][{self.model}] fuel level: {self.fuel_level}%")