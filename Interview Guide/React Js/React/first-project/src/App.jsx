import React from "react";
import Home from './components/Home.jsx'
import About from './components/About.jsx'
import Projects from './components/Projects.jsx'
import Contact from './components/Contact.jsx'

const App = ()=>{
  return(
    <div>
      <Home />
      <About />
      <Projects />
      <Contact />
    </div>
  )
}

export default App;