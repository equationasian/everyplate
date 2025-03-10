import { BrowserRouter, Route, Routes } from 'react-router'
import './App.css'
import Navbar from './Navbar'
import Home from './Home'
import Search from './Search'
import Recipe from './Recipe'

function App() {
  return (
    <>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route index element={<Home />} />
          <Route path='meals' element={<Search />} />
          <Route path='meals/:id' element={<Recipe />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App