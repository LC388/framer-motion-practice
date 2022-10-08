import React from 'react'
import { Link } from 'react-router-dom'
import {motion} from 'framer-motion'

const buttonVariants = {
    hover: {
      scale: 1.1,
      textShadow: "0px 0px 8px rgb(255,255,255)",
      boxShadow: "0px 0px 8px rgb(255,255,255)",
      transition: {
        duration: 0.3,
        yoyo: Infinity,
      },
    },
  };
  
  const containerVariants = {
    hidden: {
      opacity: 0,
    },
    visible: {
      opacity: 1,
      transition: { delay: 1.5, duration: 1.5 },
    },
    exit: {
      x: "-100vw",
      transition: {
        ease: "easeInOut",
      },
    },
  };
  

const Landing = () => {
  return (
    <>
    <motion.div className='landing container'
    variants={containerVariants}
      initial="hidden"
      animate="visible"
      exit="exit">
    <h2 className='landing--title'>Thanks for choosing Pizza Joint please...</h2>
       <div className='btn-container'>
        <Link to="/login">
        <motion.button
          variants={buttonVariants}
          animate="visible"
          whileHover="hover"
          className='login-btn'
        >
          Login
        </motion.button>
      </Link>
<p >or</p>
      <Link to="/register">
        <motion.button
          variants={buttonVariants}
          animate="visible"
          whileHover="hover"
          className='register-btn'
        >
         Register
        </motion.button>
        
      </Link>
      </div>
      </motion.div>
    </>
  )
}

export default Landing