function showGradeInputs() {
    const count = parseInt(document.getElementById("gradeCount").value);
    const container = document.getElementById("gradeInputs");
    container.innerHTML = ""; // Clear previous inputs

    if (isNaN(count) || count <= 0) {
        alert("Please enter a valid number of grades.");
        return;
    }

    for (let i = 0; i < count; i++) {
        const input = document.createElement("input");
        input.type = "number";
        input.className = "grade-input";
        input.placeholder = `Enter grade #${i + 1}`;
        input.min = 0;
        input.max = 100;
        input.step = 0.01;
        container.appendChild(input);
    }

    const calcButton = document.createElement("button");
    calcButton.textContent = "Calculate Average";
    calcButton.onclick = calculateAverage;
    container.appendChild(calcButton);
}

function calculateAverage() {
    const inputs = document.querySelectorAll(".grade-input");
    let total = 0;
    let count = 0;

    for (const input of inputs) {
        const value = parseFloat(input.value);
        if (isNaN(value) || value < 0 || value > 100) {
            alert("Please enter valid grades between 0 and 100.");
            return;
        }
        total += value;
        count++;
    }

    const average = total / count;
    document.getElementById("result").textContent = `Average Grade: ${average.toFixed(2)}`;
}
