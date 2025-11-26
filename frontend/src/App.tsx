import './App.css'; // 기본 App.css는 삭제하거나 비워두셔도 됩니다.

function App() {
  return (
    // Tailwind CSS 클래스를 직접 사용
    <div className="min-h-screen bg-gray-50 flex flex-col items-center justify-center p-8">
      <header className="text-4xl font-bold text-blue-600 mb-6">
        Route Master 🗺️
      </header>
      
      <div className="bg-white p-10 rounded-xl shadow-2xl max-w-lg w-full text-center">
        <h1 className="text-2xl font-semibold text-gray-800 mb-4">
          Frontend is Ready!
        </h1>
        <p className="text-gray-500">
          Tailwind CSS 클래스가 성공적으로 적용되었습니다.
        </p>
        <button className="mt-6 px-6 py-3 bg-indigo-500 hover:bg-indigo-600 text-white font-medium rounded-lg transition duration-150 shadow-md">
          여행 계획 시작
        </button>
      </div>
    </div>
  );
}

export default App;