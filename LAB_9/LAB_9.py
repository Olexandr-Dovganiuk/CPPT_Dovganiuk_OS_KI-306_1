from airplane import Airplane
from bomber import Bomber


# Створення екземпляра базового класу "Літак"
plane1 = Airplane("Boeing", "747")
plane1.fly()
plane1.check_fuel_level()
plane1.land()
plane1.refuel()
plane1.check_fuel_level()

# Створення екземпляра похідного класу "бомбардувальник"
bomber1 = Bomber("F-16", "Fighting Falcon", "Missiles")
bomber1.fly()
bomber1.check_fuel_level()
bomber1.drop_bombs()
bomber1.check_ammo_count()
bomber1.defend()
bomber1.reload_weapon()
bomber1.check_ammo_count()

