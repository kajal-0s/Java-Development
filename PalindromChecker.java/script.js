const input = document.getElementById('inputText');
const result = document.getElementById('result');

input.addEventListener('input', () => {
    const text = input.value;

    if (text.trim().length === 0) {
        result.className = 'hidden';
        return;
    }

    const cleaned = text.toLowerCase().replace(/[^a-z0-9]/g, '');
    const reversed = cleaned.split('').reverse().join('');

    result.className = 'visible';
    if (cleaned === reversed) {
        result.textContent = `"${text}" is a palindrome!`;
        result.classList.add('palindrome');
        result.classList.remove('not-palindrome');
    } else {
        result.textContent = `"${text}" is not a palindrome.`;
        result.classList.add('not-palindrome');
        result.classList.remove('palindrome');
    }
});
