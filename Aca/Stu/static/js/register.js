// register.js
document.addEventListener('DOMContentLoaded', () => {
  const form = document.querySelector('.form');

  form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const payload = {
      username:        form.username.value.trim(),
      password:        form.password.value,
      confirmPassword: form.confirmPassword.value,
      age:             form.age.value,
      grade:           form.grade.value
    };

    clearError();

    try {
      const res = await fetch('/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
      });
      const json = await res.json();

      if (res.ok && json.success) {
        window.location.href = '/login';
      } else {
        showError(json.message || 'Registration failed.');
      }
    } catch (err) {
      showError('Network error. Please try again.');
    }
  });
});

function showError(msg) {
  let el = document.querySelector('.error-msg');
  if (!el) {
    el = document.createElement('div');
    el.className = 'alert alert-danger mt-2 error-msg';
    document.querySelector('.form-title').after(el);
  }
  el.textContent = msg;
}

function clearError() {
  const existing = document.querySelector('.error-msg');
  if (existing) existing.remove();
}
