import {createRouter, createWebHistory} from 'vue-router';
import ContactDetails from '../views/ContactDetails.vue';
import ListeContact from '../views/ListeContact.vue';

const router = createRouter({
    history : createWebHistory(),
    routes : [
      {path: '/', component : ListeContact},
      
      {path: '/contact/:contactId' , component : ContactDetails}
     
    ]
  }
);

export default router;