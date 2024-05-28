import { Image, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import Calculator from './Components/CalculatorComponent/CalculatorComponent'




export default function App() {
    
    return (
        <View style={styles.container}>
            <Text style={styles.TextStyle}>Calculatrice</Text>
            <Calculator/>
        </View>
    )
}
const styles = StyleSheet.create({
    container:{
        flex:1,
        textAlign:'center', 
        justifyContent: 'center',
        alignItems :'center',
        backgroundColor:'black'
    },
    TextStyle:{
        textAlign:'center',
        justifyContent:'flex-start',
        color:'white'
    },

})

