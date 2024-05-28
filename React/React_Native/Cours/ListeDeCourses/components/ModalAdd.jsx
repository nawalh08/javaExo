import { Button, Modal, StyleSheet, Text, TextInput, View } from 'react-native'
import React from 'react'

export default function ModalAdd(props) {
    const Show = props.visible

  
    

    return (
        <Modal visible={Show}>
            <View>
                <TextInput onChangeText={text => props.setInputValue(text)}></TextInput>
                <Button title='Ajouter' onPress={ () => props.addToList()}/>
                <Button title='Retour' onPress={props.CloseModal}/>
            </View>
        </Modal>
    )
}

const styles = StyleSheet.create({})