<script setup>
defineProps(['modelValue'])
defineEmits(['update:modelValue'])
</script>

<template>
  <input
    placeholder="Enter le nom"
    :value="modelValue"
    @input="$emit('update:modelValue', $event.target.value)"
  />
</template>