<script setup>
import { ref } from 'vue'
import { useTodoListStore } from '../stores/todo.js'

    const todo = ref('')
    // use Pinia store:
    const store = useTodoListStore()

    
 

function addItemAndClear(item) {
  if (item.length === 0) {
    return
  }
  // invokes function in the store:
  store.addTodo(item)
 todo.value = ''
}

</script>

<template>
    <header>
        <form @submit.prevent="addItemAndClear(todo)">
            <input @keyup.enter="todo=''" v-model="todo" type="text" />
            <button>Add</button>
        </form>
    </header>
</template>