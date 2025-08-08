# app.py
import os
import requests
from flask import Flask, render_template, request, redirect, url_for, session, jsonify

app = Flask(__name__)
app.secret_key = os.environ.get("FLASK_SECRET_KEY", "your-secret-key")



# Extract the API key for use in your Flask app
FIREBASE_API_KEY = firebase_config["apiKey"]
# Firebase REST endpoints

SIGN_IN_URL = (
    f"https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key={FIREBASE_API_KEY}"
)
SIGN_UP_URL = (
    f"https://identitytoolkit.googleapis.com/v1/accounts:signUp?key={FIREBASE_API_KEY}"
)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'GET':
        return render_template('login.html')

    data = request.get_json()
    email = data.get('username')
    password = data.get('password')
    payload = {'email': email, 'password': password, 'returnSecureToken': True}

    resp = requests.post(SIGN_IN_URL, json=payload)
    if resp.ok:
        session['user'] = resp.json().get('email')
        return jsonify(success=True), 200

    error = resp.json().get('error', {}).get('message', 'Login failed')
    return jsonify(success=False, message=error), 401

@app.route('/register', methods=['GET', 'POST'])
def register():
    if request.method == 'GET':
        return render_template('register.html')

    data = request.get_json()
    username = data.get('username')
    password = data.get('password')
    confirm  = data.get('confirmPassword')
    age      = data.get('age')
    grade    = data.get('grade')

    if password != confirm:
        return jsonify(success=False, message='Passwords do not match'), 400

    payload = {'email': username, 'password': password, 'returnSecureToken': True}
    resp = requests.post(SIGN_UP_URL, json=payload)
    if resp.ok:
        # Optionally store age/grade in your own database here
        return jsonify(success=True), 200

    error = resp.json().get('error', {}).get('message', 'Registration failed')
    return jsonify(success=False, message=error), 400

@app.route('/logout', methods=['POST'])
def logout():
    session.clear()
    return jsonify(success=True), 200

if __name__ == '__main__':
    app.run(debug=True, port=5050)
