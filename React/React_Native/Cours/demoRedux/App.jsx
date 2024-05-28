import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Provider } from 'react-redux'
import { store } from './store/redux/store'
import MyId from './component/MyId'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import ScreenAdd from './screens/ScreenAdd'
import ScreenList  from './screens/ScreenList'


// Pour l'utilisation de redux :
// npm i @reduxjs/toolkit react-redux

export default function App() {
  const Stack = createNativeStackNavigator()
  return (
    <Provider store={store}>
     <NavigationContainer>
            <Stack.Navigator initialRouteName='ListeContact'>
                <Stack.Screen name='ListeId' component={ScreenList} options={{ title: "Liste D'Id" }} />
                <Stack.Screen name='AddId' component={ScreenAdd} />
            </Stack.Navigator>
        </NavigationContainer>
    </Provider>
  )
}

const styles = StyleSheet.create({})