<template>


      
    <div class="container text-center">
         <div class="row row-cols-4">
            
                <div class="col my-4">
                    <div class="card" style="width: 28rem;">
                        <div class="card-body">
                            <a href="#" data-bs-toggle="modal" :data-bs-target="'#characterModal' + props.characterList.id" ><img  class="card-img-top" @click="setCurrentCharacter(props.characterList);console.log(characterList);"  :src=characterList.image  alt="image personnage"></a>
                            <h5 class="card-title">{{ characterList.name }}</h5>
                            <p class="card-text"><span>Species :</span> {{ characterList.species }}</p>
                            
                        </div>
                    </div>
                </div>
            </div>
           
        </div>
  

  <!-- Button trigger modal -->



  <!-- Modal -->
  <div v-if="currentCharacter" class="modal fade " :id="'characterModal' + props.characterList.id" tabindex="-1"
    aria-labelledby="exampleModalLabel" aria-hidden="true" alignment="center">
    <div class="modal-dialog modal-dialog-centered">
      
<div class="modal-content">

<div class="modal-body">
  <article>
  <img class="imgModal" :src="currentCharacter.image" alt="image personnage">
</article>
<div class="details">
  <h1>{{ currentCharacter.name }}</h1>
  <p><span>Status : </span>{{ currentCharacter.status }}</p>
  <p><span>Species :</span>{{ currentCharacter.species }}</p>
  <p><span>Type : </span>{{ currentCharacter.type }}</p>
  <p><span>Gender : </span>{{ currentCharacter.gender }}</p>
  <p><span>Origin : </span>{{ currentCharacter.origin?.name }}</p>
  <p><span>Location : </span>{{ currentCharacter.location?.name }}</p>
  <p><span>Created : </span>{{ currentCharacter.created }}</p>
</div>
  <div class="modal-footer">

    <button type="button" @click="currentCharacter = null" class="btn btn-secondary"
      data-bs-dismiss="modal">Fermer</button>
  </div>
</div>
</div>
    </div>
  </div>
  
</template>
  
  
<script setup>




import { ref } from 'vue';
import { defineProps } from 'vue';
const props = defineProps(['characterList', 'id'])

let id = ref('');

const currentCharacter = ref({});

const setCurrentCharacter = (character) => {
  currentCharacter.value = character;
  console.log(currentCharacter.value);
};






function getID(A) {
  console.log(A);
  id = A

}
</script>
  
<style scoped>
.card{
  box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
}
span {
  color: green;
}
article{
  display: flex;
  align-items: flex-start;
  justify-content: left;
}


.imgModal{
  display: flex;
  height: 15vw;
  margin: auto;


}
.details{
text-align: center;
padding: auto;
}

.container {
  display: inline-block;
}

.card {
  display: block;
}

img {
  border-top-left-radius: 20px;
  border-top-right-radius: 20px;
}

.medium__item {
  margin-top: 5px;
}

.last__item {
  margin-bottom: 20px;
  margin-top: 5px;

}

.last__item>span {
  color: green;
}

span {
  font-weight: bold;
  font-size: 14px;
}
</style>
