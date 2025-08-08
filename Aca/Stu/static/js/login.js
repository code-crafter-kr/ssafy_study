// static/js/login.js

document.addEventListener('DOMContentLoaded', () => {
  const form = document.querySelector('.form');

  form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const username   = document.getElementById('username').value.trim();
    const password   = document.getElementById('password').value;
    const rememberMe = document.getElementById('rememberMe').checked;

    clearError();

    try {
      const response = await fetch('/api/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        credentials: 'include',
        body: JSON.stringify({ username, password, rememberMe })
      });

      if (response.ok) {
        // Redirect on successful login
        window.location.href = '/dashboard';
      } else {
        const { error } = await response.json();
        showError(error || 'Login failed.');
      }
    } catch (err) {
      showError('Network error. Please try again.');
    }
  });
});

/**
 * Display an error message below the form title.
 * @param {string} message
 */
function showError(message) {
  let alertDiv = document.querySelector('.error-msg');
  if (!alertDiv) {
    alertDiv = document.createElement('div');
    alertDiv.className = 'alert alert-danger mt-2 error-msg';
    document.querySelector('.form-title').after(alertDiv);
  }
  alertDiv.textContent = message;
}

/**
 * Remove any existing error message.
 */
function clearError() {
  const existingAlert = document.querySelector('.error-msg');
  if (existingAlert) existingAlert.remove();
}
