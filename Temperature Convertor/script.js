function convertTemperature() {
  const temp = parseFloat(document.getElementById("inputTemp").value);
  const from = document.getElementById("fromUnit").value;
  const to = document.getElementById("toUnit").value;
  let result;

  if (isNaN(temp)) {
    result = "Please enter a valid number.";
  } else {
    if (from === to) {
      result = temp;
    } else if (from === "celsius") {
      if (to === "fahrenheit") {
        result = (temp * 9/5) + 32;
      } else if (to === "kelvin") {
        result = temp + 273.15;
      }
    } else if (from === "fahrenheit") {
      if (to === "celsius") {
        result = (temp - 32) * 5/9;
      } else if (to === "kelvin") {
        result = ((temp - 32) * 5/9) + 273.15;
      }
    } else if (from === "kelvin") {
      if (to === "celsius") {
        result = temp - 273.15;
      } else if (to === "fahrenheit") {
        result = ((temp - 273.15) * 9/5) + 32;
      }
    }
  }

  document.getElementById("result").innerText = 
    isNaN(result) ? result : `Converted Temperature: ${result.toFixed(2)}° ${to.charAt(0).toUpperCase() + to.slice(1)}`;
}
