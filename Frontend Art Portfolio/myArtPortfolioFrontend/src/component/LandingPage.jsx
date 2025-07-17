import React from "react";
// import { Button } from "@/components/ui/button";

export default function LandingPage() {
  return (
    <main className="w-full min-h-screen bg-cover bg-center bg-no-repeat" style={{ backgroundImage: `url('/dbd3014c-bb92-4965-a85d-62d688d60abe.png')` }}>
      <div className="bg-black/50 w-full min-h-screen flex flex-col justify-between">
        <header className="flex justify-between items-center px-10 py-6 text-white">
          <h1 className="text-2xl font-semibold tracking-widest">YOUR NAME STUDIO</h1>
          <nav className="space-x-6 hidden md:flex">
            <a href="#about" className="hover:underline">About</a>
            <a href="#paintings" className="hover:underline">Paintings</a>
            <a href="#portfolio" className="hover:underline">Portfolio</a>
            <a href="#cv" className="hover:underline">CV</a>
            <a href="#contact" className="hover:underline">Contact</a>
          </nav>
        </header>

        <div className="flex-1 flex items-center justify-center text-white text-center px-6">
          <div>
            <h2 className="text-4xl md:text-6xl font-bold mb-4">Welcome to My Studio</h2>
            <p className="text-lg md:text-xl max-w-xl mx-auto mb-6">
              Explore a world of colors, textures, and expressions through my contemporary artworks.
            </p>
            <Button className="bg-white text-black hover:bg-gray-200">View Portfolio</Button>
          </div>
        </div>

        <footer className="md:hidden bg-black/70 p-4 flex justify-center space-x-4 text-white">
          <a href="#about">About</a>
          <a href="#paintings">Paintings</a>
          <a href="#portfolio">Portfolio</a>
          <a href="#cv">CV</a>
          <a href="#contact">Contact</a>
        </footer>
      </div>
    </main>
  );
}
