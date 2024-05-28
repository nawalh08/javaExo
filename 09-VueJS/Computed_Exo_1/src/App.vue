<script setup>
import {ref, computed, reactive} from 'vue';

let Personne = reactive({Name: "Fares",Lastname:"Dries",Day:"20",Month:"04",Year:"2001",Age: "22"})

console.log(Personne);

function addyear(Personne){
  Personne.Year=Number(Personne.Year)+1;
  console.log(Personne);
  Age
  console.log(Age.value);
}
const Age = computed(() => {
  
//   let today = Date.now()
//  console.log(today);
//  return today;
const current = new Date();
      const date = `${current.getDate()}/${current.getMonth()+1}/${current.getFullYear()}`;
      console.log(date);
      Personne.Age = current.getFullYear()- Personne.Year  ;
      return Personne.Age;



  
})





addyear(Personne)

console.log(Personne);
</script>

<template>

  <button v-on:click="addyear(Personne)">Ajouter un an</button>
  

</template>

<style scoped>

</style>
