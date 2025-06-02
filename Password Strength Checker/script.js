document.getElementById('password').addEventListener('input', function () {
  const password = this.value;
  const strengthDisplay = document.getElementById('strength');

  const hasLower = /[a-z]/.test(password);
  const hasUpper = /[A-Z]/.test(password);
  const hasNumber = /[0-9]/.test(password);
  const hasSpecial = /[^A-Za-z0-9]/.test(password);
  const length = password.length;

  let strength = 0;
  if (hasLower) strength++;
  if (hasUpper) strength++;
  if (hasNumber) strength++;
  if (hasSpecial) strength++;
  if (length >= 8) strength++;

  let message = "";
  let color = "";

  switch (strength) {
    case 0:
    case 1:
      message = "Very Weak";
      color = "red";
      break;
    case 2:
      message = "Weak";
      color = "orange";
      break;
    case 3:
      message = "Moderate";
      color = "goldenrod";
      break;
    case 4:
      message = "Strong";
      color = "green";
      break;
    case 5:
      message = "Very Strong";
      color = "darkgreen";
      break;
  }

  strengthDisplay.textContent = message;
  strengthDisplay.style.color = color;
});
