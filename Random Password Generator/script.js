function generatePassword() {
  const length = document.getElementById('length').value;
  const includeNumbers = document.getElementById('numbers').checked;
  const includeLower = document.getElementById('lowercase').checked;
  const includeUpper = document.getElementById('uppercase').checked;
  const includeSpecial = document.getElementById('special').checked;

  let charSet = '';
  if (includeNumbers) charSet += '0123456789';
  if (includeLower) charSet += 'abcdefghijklmnopqrstuvwxyz';
  if (includeUpper) charSet += 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
  if (includeSpecial) charSet += '!@#$%^&*()_+[]{}|;:,.<>?';

  if (charSet === '') {
    document.getElementById('result').innerText = "Please select at least one character type.";
    return;
  }

  let password = '';
  for (let i = 0; i < length; i++) {
    const randIndex = Math.floor(Math.random() * charSet.length);
    password += charSet[randIndex];
  }

  document.getElementById('result').innerText = `Generated Password: ${password}`;
}
