function processFile(action) {
  const fileInput = document.getElementById('fileInput');
  const keyInput = document.getElementById('keyInput');
  const message = document.getElementById('message');
  const downloadLink = document.getElementById('downloadLink');

  if (!fileInput.files.length || !keyInput.value) {
    message.textContent = "Please select a file and enter a key.";
    message.style.color = "red";
    return;
  }

  const file = fileInput.files[0];
  const key = parseInt(keyInput.value);

  const reader = new FileReader();
  reader.onload = function(e) {
    const content = e.target.result;
    const processed = caesarCipher(content, key, action);
    const blob = new Blob([processed], { type: 'text/plain' });

    downloadLink.href = URL.createObjectURL(blob);
    downloadLink.download = file.name + (action === 'encrypt' ? '.enc.txt' : '.dec.txt');
    downloadLink.style.display = 'inline-block';
    downloadLink.textContent = "Download " + (action === 'encrypt' ? "Encrypted" : "Decrypted") + " File";
    message.textContent = "File processed successfully!";
    message.style.color = "green";
  };
  reader.readAsText(file);
}

function caesarCipher(text, key, mode) {
  let result = '';
  for (let char of text) {
    let code = char.charCodeAt(0);
    if (mode === 'encrypt') {
      code = (code + key) % 256;
    } else {
      code = (code - key + 256) % 256;
    }
    result += String.fromCharCode(code);
  }
  return result;
}
