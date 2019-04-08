package com.mashkovich.car.models.cars;

public enum ModelsOfCars {
	
	 M3(Cars.BMW), M4(Cars.BMW), M5(Cars.BMW), M6(Cars.BMW), X3(Cars.BMW), X4(Cars.BMW),
	 Freed(Cars.Honda),Integra(Cars.Honda), Ascot(Cars.Honda),
	 LACETTI(Cars.Chevrolet),ORLANDO(Cars.Chevrolet),TRACKER(Cars.Chevrolet),CORVETTE(Cars.Chevrolet),
	 RAPID(Cars.Skoda),KAROQ(Cars.Skoda),SUNROQ(Cars.Skoda),
	 Q5(Cars.Audi),Q7(Cars.Audi),Q8(Cars.Audi);
	 private Cars car;

	 ModelsOfCars (Cars car){
		 this.car =car;
	 }
	 public Cars getCars() {
		 return car;
	 }
}


