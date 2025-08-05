import os
import requests
from flask import Flask, render_template, request, redirect, url_for, session, jsonify

app = Flask(__name__)
app.secret_key = os.environ.get("FLASK_SECRET_KEY", "your-secret-key")

# Firebase Auth REST API endpoints
FIREBASE_API_KEY = os.environ.get("FIREBASE_API_KEY")
FIREBASE_AUTH_URL = (
    f"https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key={FIREBASE_API_KEY}"
)

@app.route('/register', methods=['GET', 'POST'])
def register():
    if request.method == 'POST':
        data = request.get_json()
        username = data.get('username')
        password = data.get('password')
        confirm_password = data.get('confirmPassword')
        age = data.get('age')
        grade = data.get('grade')
        if password != confirm_password:
            return jsonify({'success': False, 'message': 'Passwords do not match'}), 400
        # TODO: Integrate with Firebase Auth to create user
        return jsonify({'success': True}), 200
    return render_template('register.html')

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        data = request.get_json()
        email = data.get('username')
        password = data.get('password')
        payload = {'email': email, 'password': password, 'returnSecureToken': True}
        res = requests.post(FIREBASE_AUTH_URL, json=payload)
        if res.status_code == 200:
            session['user'] = res.json().get('email')
            return jsonify({'success': True}), 200
        else:
            return jsonify({'success': False, 'message': 'Invalid credentials'}), 401
    return render_template('login.html')

@app.route('/logout', methods=['POST'])
def logout():
    session.clear()
    return jsonify({'success': True}), 200

@app.route('/')
def index():
    if 'user' in session:
        return render_template('logout.html', email=session['user'])
    return redirect(url_for('login'))

if __name__ == '__main__':
    app.run(debug=True, port=5050)