import { defineStore } from "pinia";
import { ref } from "vue";

export const useCharactersStore = defineStore('characters', () => {

    const data = ref('');
    const data2 =ref('')

    async function getCharacterByPage(page,name,etat,gender,species,type) {

        try {
          const response = await fetch(`https://rickandmortyapi.com/api/character/?page=${page}&name=${name}&status=${etat}&gender=${gender}&species=${species}&type=${type}`);
          if (!response.ok) {
            throw new Error('Erreur lors du chargement des données');
          }
          const jsonData = await response.json();
          data.value = jsonData; 
      
          console.log(data.value.results);
        } catch (error) {
          console.error('Erreur:', error);
        }
      }
    async function getCharacterByID(id) {

        try {
          const response = await fetch(`https://rickandmortyapi.com/api/character/${id}`);
          if (!response.ok) {
            throw new Error('Erreur lors du chargement des données');
          }
          const jsonData = await response.json();
          data2.value = jsonData; 
      
          console.log(data.value.results);
        } catch (error) {
          console.error('Erreur:', error);
        }
      }
      
      return {data,data2,getCharacterByPage,getCharacterByID}
})