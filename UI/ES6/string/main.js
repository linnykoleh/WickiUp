/** String template */
/** Интерполяция строк */

const text = 'test span';

const htmlOld = '<div><p><span>' + text + '</span></p></div>';
const htmlNew = `<div><p><span>${text}</span></p></div>`;

console.log(htmlOld); // <div><p><span>test span</span></p></div>
console.log(htmlNew); // <div><p><span>test span</span></p></div>