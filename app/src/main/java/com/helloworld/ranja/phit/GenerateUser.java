package com.helloworld.ranja.phit;
public class GenerateUser {
    public boolean sex = true;
    public double weight = 0.0;
    public double wristCircumference = 0.0;
    public double waistCircumference = 0.0;
    public double forearmCircumference = 0.0;
    public double hipCircumference = 0.0;
    public double height = 0.0;
    public GenerateUser() {
        sex = true;
        weight = 0.0;
        wristCircumference = 0.0;
        waistCircumference = 0.0;
        forearmCircumference = 0.0;
        hipCircumference = 0.0;
        height = 0.0;

    }
    public double[] determineFactors() {
        if(sex) {
            double[] ret = {(weight * 1.082) + 94.42, waistCircumference * 4.15};
            return ret;
        }else {
            double[] ret = {(weight * .732) + 8.987, wristCircumference / 3.140, waistCircumference * .157, hipCircumference * .249, forearmCircumference * .434};
            return ret;
        }

    }
    public double determineLeanBodyMass(double[] a) {
        if(sex){
            return a[0] - a[1];
        }else{
            return a[0] + a[1] - a[2] - a[3] + a[4];
        }
    }
    public double determineBodyFatWeight() {
        return weight - determineLeanBodyMass(determineFactors());
    }
    public double determineBodyFatPercent() {
        return (determineBodyFatWeight() * 100)/weight;
    }
    public double determineBMI(double weight, double height) {
        return (weight * 703)/(height * height);
    }
    public String getSex() {
        return sex? "Male":"Female";
    }
    public double getWeight() {
        return weight;
    }
    public double getHeight() {
        return height;
    }
    public double getWaistCircumference() {
        return waistCircumference;
    }
    public double getForearmCircumference() {
        return forearmCircumference;
    }
    public double getWristCircumference() {
        return wristCircumference;
    }
    public double getHipCircumference() {
        return hipCircumference;
    }
    public void setSex(boolean s) {
        sex = s;
    }
    public void setWeight(double w) {
        weight = w;
    }
    public void setHeight(double h) {
        height = h;
    }
    public void setWaistCircumference(double wc) {
        waistCircumference = wc;
    }
    public void setForearmCircumference(double fc) {
        forearmCircumference = fc;
    }
    public void setWristCircumference(double wc) {
        wristCircumference = wc;
    }
    public void setHipCircumference(double hc) {
        hipCircumference = hc;
    }
    public String determineHealth() {
        //point-slope form for height which is compare in this statement
		/*
		double compare = (12.0/42.0)*(weight-98)+61;
		if(height>compare) {
			return "You at at an unhealty range for your characteristics.";
		}
		compare = (11.0/56.0)*(weight-210)+77;
		if(height>compare) {
			return "You are at a heatlthy range for your characteristics.";
		}
		compare = (19.0/112.0)*(weight-266)+79;
		if(height>compare) {
			return "You are at an overweight range for your characteristics.";
		}
			return "You are at an obese range for your characteristics.";
		*/
        if (sex){
            if (determineBodyFatPercent()> 6 || determineBodyFatPercent() < 13){
                return "Based on your body fat percentage, you are catagorized as athletic";
            }
            else if (determineBodyFatPercent() > 14 || determineBodyFatPercent() < 17){
                return "Based on your body fat percentage, you are catagorized as fit";
            }
            else if (determineBodyFatPercent() > 18 || determineBodyFatPercent() < 25){
                return "Based on your body fat percentage, you are catagorized as average";
            }
            else if (determineBodyFatPercent() >25){
                return "Based on your body fat percentage, you are catagorized as obese";
            }
        }
        else{
            if(determineBodyFatPercent()> 14 || determineBodyFatPercent() <20){
                return "Based on your body fat percentage, you are catagorized as athletic";
            }
            else if(determineBodyFatPercent()>21||determineBodyFatPercent()<24){
                return "Based on your body fat percentage, you are catagorized as fit";
            }
            else if(determineBodyFatPercent()>25||determineBodyFatPercent()<31){
                return "Based on your body fat percentage, you are catagorized as average";
            }
            else if(determineBodyFatPercent()>32){
                return "Based on your body fat percentage, you are catagorized as obese";
            }
        }
        return "error";

    }
}

