import React, { useState, useEffect } from 'react';
import { Camera, Sparkles, Scan } from 'lucide-react';

export default function Home() {
  const [isVisible, setIsVisible] = useState(false);

  useEffect(() => {
    setIsVisible(true);
  }, []);

  return (
    <div className="min-h-screen w-full bg-gradient-to-br from-indigo-900 via-purple-900 to-blue-900 flex items-center justify-center p-8 overflow-hidden relative">
      {/* Animated background elements */}
      <div className="absolute inset-0 overflow-hidden">
        <div className="absolute top-1/4 left-1/4 w-96 h-96 bg-purple-500 rounded-full mix-blend-multiply filter blur-3xl opacity-20 animate-pulse" 
             style={{ animationDuration: '4s' }}></div>
        <div className="absolute top-1/3 right-1/4 w-96 h-96 bg-blue-500 rounded-full mix-blend-multiply filter blur-3xl opacity-20 animate-pulse" 
             style={{ animationDuration: '6s', animationDelay: '1s' }}></div>
        <div className="absolute bottom-1/4 left-1/2 w-96 h-96 bg-indigo-500 rounded-full mix-blend-multiply filter blur-3xl opacity-20 animate-pulse" 
             style={{ animationDuration: '5s', animationDelay: '2s' }}></div>
      </div>

      {/* Main content */}
      <div className={`relative z-10 text-center transition-all duration-1000 transform ${
        isVisible ? 'opacity-100 translate-y-0' : 'opacity-0 translate-y-8'
      }`}>
        {/* Logo/Icon area */}
        <div className="mb-8 flex justify-center">
          <div className="relative">
            <div className="absolute inset-0 bg-white rounded-full blur-2xl opacity-30 animate-pulse"></div>
            <div className="relative bg-white/10 backdrop-blur-sm rounded-full p-8 border border-white/20">
              <Camera className="w-20 h-20 text-white" strokeWidth={1.5} />
            </div>
          </div>
        </div>

        {/* Welcome text */}
        <h1 className="text-7xl md:text-8xl font-bold text-white mb-6 tracking-tight">
          Welcome
        </h1>
        
        <div className="flex items-center justify-center gap-3 mb-8">
          <div className="h-px w-16 bg-gradient-to-r from-transparent to-white/50"></div>
          <Sparkles className="w-6 h-6 text-purple-300 animate-pulse" />
          <div className="h-px w-16 bg-gradient-to-l from-transparent to-white/50"></div>
        </div>

        <p className="text-3xl md:text-4xl text-white/90 font-light mb-4 max-w-4xl mx-auto leading-relaxed">
          Show me any object
        </p>
        <p className="text-3xl md:text-4xl text-white/90 font-light mb-12 max-w-4xl mx-auto leading-relaxed">
          and I'll identify it for you
        </p>

        {/* Instruction */}
        <div className="inline-flex items-center gap-3 bg-white/10 backdrop-blur-md rounded-full px-8 py-4 border border-white/20">
          <Scan className="w-6 h-6 text-purple-300 animate-pulse" style={{ animationDuration: '2s' }} />
          <span className="text-xl text-white/80 font-medium">Point your camera to begin</span>
        </div>

        {/* Subtle bottom decoration */}
        <div className="mt-16 flex justify-center gap-2">
          {[...Array(3)].map((_, i) => (
            <div
              key={i}
              className="w-2 h-2 rounded-full bg-white/40 animate-pulse"
              style={{ animationDelay: `${i * 0.3}s`, animationDuration: '1.5s' }}
            ></div>
          ))}
        </div>
      </div>

      {/* Corner accents */}
      <div className="absolute top-0 left-0 w-32 h-32 border-t-2 border-l-2 border-white/10"></div>
      <div className="absolute top-0 right-0 w-32 h-32 border-t-2 border-r-2 border-white/10"></div>
      <div className="absolute bottom-0 left-0 w-32 h-32 border-b-2 border-l-2 border-white/10"></div>
      <div className="absolute bottom-0 right-0 w-32 h-32 border-b-2 border-r-2 border-white/10"></div>
    </div>
  );
}