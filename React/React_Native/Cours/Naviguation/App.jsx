import { Image, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import ScreenListe from './screens/ScreenListe'
import ScreenDetail from './screens/ScreenDetail'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'



const Stack = createNativeStackNavigator()

export default function App() {
    return (

        <NavigationContainer>
            <Stack.Navigator initialRouteName='ListeContact'>
                <Stack.Screen name='ListeContact' component={ScreenListe} options={{ title: "ListeDeContact" }} />
                <Stack.Screen name='DetailContact' component={ScreenDetail} />
            </Stack.Navigator>
        </NavigationContainer>


    )
}
