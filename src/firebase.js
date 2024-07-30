import firebase from 'firebase/app';
 import 'firebase/messaging';

 const firebaseConfig = {
   // ... (Your Firebase config object)
 };

 firebase.initializeApp(firebaseConfig);
 const messaging = firebase.messaging();

 export { messaging };
